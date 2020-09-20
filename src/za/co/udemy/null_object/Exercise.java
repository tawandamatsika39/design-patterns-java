package za.co.udemy.null_object;

interface Log
{
    // max # of elements in the log
    int getRecordLimit();

    // number of elements already in the log
    int getRecordCount();

    // expected to increment record count
    void logInfo(String message);
}

class Account
{
    private Log log;

    public Account(Log log)
    {
        this.log = log;
    }

    public void someOperation() throws Exception
    {
        int c = log.getRecordCount();
        log.logInfo("Performing an operation");
        if (c+1 != log.getRecordCount())
            throw new Exception();
        if (log.getRecordCount() >= log.getRecordLimit())
            throw new Exception();
    }
}

class NullLog implements Log {
    int value = 0;

    @Override
    public int getRecordLimit() {
        return value++;
    }

    @Override
    public int getRecordCount() {
        return value++;
    }

    @Override
    public void logInfo(String message) {
    }
}

public class Exercise {
    public static void main(String[] args) throws Exception {
        NullLog log = new NullLog();
        Account account = new Account(log);
        account.someOperation();
    }
}
