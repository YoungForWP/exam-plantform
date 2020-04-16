package exam.answerSheetContext.domain.model.answerSheet;

import exam.answerSheetContext.domain.model.shared.Entity;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class AnswerSheet implements Entity<AnswerSheet> {
  private String id;
  private String studentId;
  private String examinationId;
  private List<Answer> answers;

  public static AnswerSheet assign(String id, String studentId, String examinationId) {
    return AnswerSheet.builder()
        .id(id)
        .studentId(studentId)
        .examinationId(examinationId)
        .answers(new ArrayList<>())
        .build();
  }

  public void submit(Answer answer) {
    answers.add(answer);
  }

  @Override
  public boolean isSameIdentifyWith(AnswerSheet other) {
    return this.id.equals(other.id);
  }
}
