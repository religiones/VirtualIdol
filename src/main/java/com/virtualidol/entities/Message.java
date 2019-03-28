package com.virtualidol.entities;

public class Message<T>
{
    private T res;

    public void setResult(T res)
    {
        this.res = res;
    }

    public T getResult() {
        return this.res;
    }
}