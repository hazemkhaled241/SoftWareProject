public interface IAdmin {
    void suspendClient(Integer index);
    void unSuspendClient(Integer index);
    void suspendDriver(Integer index);
    void unSuspendDriver(Integer index);
    void acceptDriverRequest(Integer index);
    void rejectDriverRequest(Integer index);
}
