package company.model2;

public interface WorkType {
    WorkType Synchronous = () -> true;
    WorkType Asynchronous = () -> false;

    boolean isSynchronous();
}
