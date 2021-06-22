//SharePtr和WeakPtr的区别？
//智能指针需要实现哪些方法？
//如何保存引用计数？
//线程安全问题？？？
//WeakPtr的实现要点？？？

#include <iostream>
using namespace std;

template<typename T>
class MySharePtr {
public:
	MySharePtr(T* ptr) {
		ref_count_ = new int(1);
	}

	~MySharePtr() {
		*ref_count_--;
		if (*ref_count_ <= 0) delete ptr;
	}

	//复制构造函数
	MySharePtr(const MySharePtr& ptr) {


	}
	//赋值操作符
	MySharePtr& operator=(const MySharePtr& ptr) {
		*ref_count++;
	}

private:
	int* ref_count_;
	T* ptr_;
};


template<typename T>
class MyWeakPtr {
public:

private:
};


int main() {
	cout << "hello world" << endl;
	system("pause");
	return 0;
}