package exam.paperContext.domain.model.paper;

import exam.paperContext.domain.shared.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Set;

@Getter
@AllArgsConstructor
public class Paper implements Entity<Paper> {
  private String id;
  private String teacherId;
  private Set<String> blankQuizIds;

  public static Paper assemble(String id, String teacherId, Set<String> blankQuizIds) {
    if (blankQuizIds.size() == 0) {
      throw new NoQuizzesException("There is no quizzes");
    }
    return new Paper(id, teacherId, blankQuizIds);
  }

  public Set<String> getBlankQuizIds() {
    return Collections.unmodifiableSet(blankQuizIds);
  }

  @Override
  public boolean isSameIdentifyWith(Paper other) {
    return this.id.equals(other.id);
  }
}
