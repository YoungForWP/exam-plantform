package exam.examinationContext.domain.model.examination;

import exam.paperContext.domain.shared.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@AllArgsConstructor
public class Examination implements Entity<Examination> {
  private String id;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Paper paper;

  public static Examination create(String id, LocalDateTime startDate, LocalDateTime endDate, Paper paper) {
    if (startDate.plusHours(2).isBefore(endDate)) {
      throw new InvalidExaminationDurationTimeException("The examination duration time should be less than 2 hours");
    }

    Set<BlankQuiz> blankQuizList = paper.getBlankQuizList();
    if (blankQuizList.size() < 5) {
      throw new TooLittleQuizzesException("The amount of blankQuiz should more than 5");
    }

    if (blankQuizList.size() > 20) {
      throw new TooManyQuizzesException("The amount of blankQuiz should less than 20");
    }

    Integer totalScore = blankQuizList.stream()
        .map(BlankQuiz::getScore)
        .reduce(0, Integer::sum);

    if (!totalScore.equals(100)) {
      throw new InvalidTotalScoreException("The total score of the paper must be 100");
    }

    return new Examination(id, startDate, endDate, paper);
  }

  @Override
  public boolean isSameIdentifyWith(Examination other) {
    return this.id.equals(other.id);
  }
}
