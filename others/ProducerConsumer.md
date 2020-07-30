# 生产者消费者

## 思路

这是一道典型的多线程问题，需要用到条件变量来解决

## 注意

java中lock的使用,需要保证lock的释放

```java
Lock lock = ...;
lock.lock();
try{

}finally{
    lock.unlock();
}
```

