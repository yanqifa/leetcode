#include <iostream>
#include <thread>
#include <queue>
#define CAPACITY 10

std::mutex mtx;
std::condition_variable notEmpty, notFull;
std::queue<int> q;
int i = 0;

void consume(){
    while(true){
        std::this_thread::sleep_for(std::chrono::milliseconds(1000));
        std::unique_lock<std::mutex> lock(mtx);
        if(q.size() == 0){
            notEmpty.wait(lock);
        }
        int element = q.front();
        q.pop();
        std::cout << "consumer consume : " << element << std::endl;
        notFull.notify_all();
    }
}

void produce(){
    while(true){
        std::this_thread::sleep_for(std::chrono::milliseconds(1000));
        std::unique_lock<std::mutex> lock(mtx);
        if(q.size() == CAPACITY){
            notFull.wait(lock);
        }
        std::cout << "producer produce : " << i % 10 << std::endl;
        q.push(i++ % 10);
        notEmpty.notify_all();
    }
}

int main(){
    std::thread producer(produce);
    std::thread consumer(consume);
    producer.join();
    consumer.join();
}
