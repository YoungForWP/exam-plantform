package exam.examinationContext.domain.model.examination;

public class InvalidExaminationDurationTimeException extends RuntimeException {
  InvalidExaminationDurationTimeException(String message) {
    super(message);
  }
}
