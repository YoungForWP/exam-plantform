package exam.answerSheetContext.domain.model.answerSheet;

public interface AnswerSheetRepository {
  void save(AnswerSheet answerSheet);

  AnswerSheet get(String id);
}
