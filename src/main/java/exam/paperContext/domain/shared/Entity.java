package exam.paperContext.domain.shared;

public interface Entity<T> {
  boolean isSameIdentifyWith(T other);
}
