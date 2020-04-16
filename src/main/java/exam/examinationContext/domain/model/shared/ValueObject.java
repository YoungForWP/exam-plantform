package exam.examinationContext.domain.model.shared;

public interface ValueObject<T> {
  boolean isSameValueWith(T other);
}
