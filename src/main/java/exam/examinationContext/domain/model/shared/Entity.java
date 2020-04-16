package exam.examinationContext.domain.model.shared;

public interface Entity<T> {
  boolean isSameIdentifyWith(T other);
}
