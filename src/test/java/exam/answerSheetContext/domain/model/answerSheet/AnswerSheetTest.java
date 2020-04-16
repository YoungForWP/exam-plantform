package exam.answerSheetContext.domain.model.answerSheet;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnswerSheetTest {

  @Test
  public void shouldAssignTheAnswerSheet() {
    String id = "id";
    String studentId = "studentId";
    String examinationId = "examinationId";

    AnswerSheet answerSheet = AnswerSheet.assign(id, studentId, examinationId);

    assertThat(answerSheet.getId(), is(id));
    assertThat(answerSheet.getStudentId(), is(studentId));
    assertThat(answerSheet.getExaminationId(), is(examinationId));
  }

  @Test
  public void shouldSupportToSubmitAnswer() {
    AnswerSheet answerSheet = AnswerSheet.assign("id", "studentId", "examinationId");

    Answer answer = new Answer("answerId", "content");
    answerSheet.submit(answer);

    assertThat(answerSheet.getAnswers().size(), is(1));
    assertThat(answerSheet.getAnswers().get(0), is(answer));
  }
}
