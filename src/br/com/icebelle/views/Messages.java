package br.com.icebelle.views;

public class Messages {
    public void setSuccess(String message) {
        System.out.print("\u001B[32m" + message);
    }

    public void setFail(String message) {
        System.out.print("\u001B[31m" + message);
    }

    public void setInfo(String message) {
        System.out.print("\u001B[36m" + message);
    }

    public void setWarning(String message) {
        System.out.print("\u001B[33m" + message);
    }

    public void setDefault(String message) {
        System.out.print("\u001B[0m" + message);
    }
}
