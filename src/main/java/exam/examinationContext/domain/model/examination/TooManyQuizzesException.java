package exam.examinationContext.domain.model.examination;

class TooManyQuizzesException extends RuntimeException {

  TooManyQuizzesException(String message) {
    super(message);
  }
}
