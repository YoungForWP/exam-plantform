package exam.examinationContext.domain.model.examination;

class TooLittleQuizzesException extends RuntimeException {

  TooLittleQuizzesException(String message) {
    super(message);
  }
}
