package exam.examinationContext.domain.model.examination;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExaminationTest {
  @Test
  public void shouldCreateExamination() {
    String examinationId = "examinationId";
    LocalDateTime startDate = LocalDateTime.now();
    LocalDateTime endDate = LocalDateTime.now().plusMinutes(50);

    Set<BlankQuiz> quizzes = IntStream.range(0, 5)
        .mapToObj(n -> new BlankQuiz("id" + n, "desc", "referenceAnswer", 20))
        .collect(Collectors.toSet());

    Paper paper = new Paper("paperId", "teacherId", quizzes);

    Examination examination = Examination.create(examinationId, startDate, endDate, paper);

    assertThat(examination.getId(), is(examinationId));
    assertThat(examination.getStartDate(), is(startDate));
    assertThat(examination.getEndDate(), is(endDate));
    assertThat(examination.getPaper(), is(paper));
  }

  @Test(expected = InvalidExaminationDurationTimeException.class)
  public void shouldThrowExceptionWhenExaminationExceed2Hour() {
    String examinationId = "examinationId";
    LocalDateTime startDate = LocalDateTime.now();
    LocalDateTime endDate = LocalDateTime.now().plusHours(3);

    Set<BlankQuiz> quizzes = IntStream.range(0, 5)
        .mapToObj(n -> new BlankQuiz("id" + n, "desc", "referenceAnswer", 20))
        .collect(Collectors.toSet());

    Paper paper = new Paper("paperId", "teacherId", quizzes);

    Examination.create(examinationId, startDate, endDate, paper);
  }

  @Test(expected = TooLittleQuizzesException.class)
  public void shouldThrowExceptionWhenQuizzesSizeLessThan5() {
    String examinationId = "examinationId";
    LocalDateTime startDate = LocalDateTime.now();
    LocalDateTime endDate = LocalDateTime.now().plusHours(1);

    Set<BlankQuiz> quizzes = Set.of(new BlankQuiz("id", "desc", "referenceAnswer", 100));
    Paper paper = new Paper("paperId", "teacherId", quizzes);

    Examination.create(examinationId, startDate, endDate, paper);
  }

  @Test(expected = TooManyQuizzesException.class)
  public void shouldThrowExceptionWhenQuizzesSizeMoreThan20() {
    String examinationId = "examinationId";
    LocalDateTime startDate = LocalDateTime.now();
    LocalDateTime endDate = LocalDateTime.now().plusHours(1);

    Set<BlankQuiz> quizzes = IntStream.range(0, 25)
        .mapToObj(n -> new BlankQuiz("id" + n, "desc", "referenceAnswer", 4))
        .collect(Collectors.toSet());

    Paper paper = new Paper("paperId", "teacherId", quizzes);

    Examination.create(examinationId, startDate, endDate, paper);
  }

  @Test(expected = InvalidTotalScoreException.class)
  public void shouldThrowExceptionWhenTotalScoreLessThan100() {
    String examinationId = "examinationId";
    LocalDateTime startDate = LocalDateTime.now();
    LocalDateTime endDate = LocalDateTime.now().plusHours(1);

    Set<BlankQuiz> quizzes = IntStream.range(0, 15)
        .mapToObj(n -> new BlankQuiz("id" + n, "desc", "referenceAnswer", 1))
        .collect(Collectors.toSet());

    Paper paper = new Paper("paperId", "teacherId", quizzes);

    Examination.create(examinationId, startDate, endDate, paper);
  }

  @Test(expected = InvalidTotalScoreException.class)
  public void shouldThrowExceptionWhenTotalScoreMoreThan100() {
    String examinationId = "examinationId";
    LocalDateTime startDate = LocalDateTime.now();
    LocalDateTime endDate = LocalDateTime.now().plusHours(1);

    Set<BlankQuiz> quizzes = IntStream.range(0, 15)
        .mapToObj(n -> new BlankQuiz("id" + n, "desc", "referenceAnswer", 20))
        .collect(Collectors.toSet());

    Paper paper = new Paper("paperId", "teacherId", quizzes);

    Examination.create(examinationId, startDate, endDate, paper);
  }

}
