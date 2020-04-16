package exam.examinationContext.domain.model.examination;

import exam.examinationContext.domain.model.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.Set;

@Getter
@AllArgsConstructor
class Paper implements ValueObject<Paper> {
  private String id;
  private String teacherId;
  private Set<BlankQuiz> blankQuizList;

  @Override
  public boolean isSameValueWith(Paper other) {
    return this.equals(other);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Paper paper = (Paper) o;
    return id.equals(paper.id) &&
        teacherId.equals(paper.teacherId) &&
        blankQuizList.equals(paper.blankQuizList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, teacherId, blankQuizList);
  }
}
