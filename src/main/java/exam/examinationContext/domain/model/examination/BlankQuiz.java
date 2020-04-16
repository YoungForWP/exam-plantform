package exam.examinationContext.domain.model.examination;

import exam.examinationContext.domain.model.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
@Builder
public class BlankQuiz implements ValueObject<BlankQuiz> {
  private String id;
  private String description;
  private String referenceAnswer;
  private int score;

  @Override
  public boolean isSameValueWith(BlankQuiz other) {
    return this.equals(other);
  }

  @Override
  public boolean equals(Object o) {
    if (this.equals(o)) {
      return true;
    }
    if (o == null || !getClass().equals(o.getClass())) {
      return false;
    }
    BlankQuiz blankQuiz = (BlankQuiz) o;
    return score == blankQuiz.score &&
        Objects.equals(id, blankQuiz.id) &&
        Objects.equals(description, blankQuiz.description) &&
        Objects.equals(referenceAnswer, blankQuiz.referenceAnswer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, referenceAnswer, score);
  }
}
