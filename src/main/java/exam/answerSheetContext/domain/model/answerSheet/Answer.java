package exam.answerSheetContext.domain.model.answerSheet;

import exam.answerSheetContext.domain.model.shared.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Answer implements Entity<Answer> {
  private String id;
  private String content;

  @Override
  public boolean isSameIdentifyWith(Answer other) {
    return this.id.equals(other.id);
  }
}
