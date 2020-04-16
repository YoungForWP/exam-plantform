package exam.paperContext.domain.model.paper;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class PaperTest {

  @Test
  public void shouldCreatePaper() {
    String paperId = "paperId";
    String teacherId = "teacherId";
    Set<String> quizzes = Set.of("quiz1", "quiz2");

    Paper paper = Paper.assemble(paperId, teacherId, quizzes);

    assertThat(paper.getId(), is(paperId));
    assertThat(paper.getTeacherId(), is(teacherId));
    assertThat(paper.getBlankQuizIds(), is(quizzes));
  }

  @Test(expected = NoQuizzesException.class)
  public void shouldThrowExceptionWhenThereNoQuizzes() {
    Paper.assemble("paperId", "teacherId", Collections.emptySet());
  }
}
