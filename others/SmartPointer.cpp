//SharePtr和WeakPtr的区别？
//智能指针需要实现哪些方法？
//如何保存引用计数？
//线程安全问题？对同一个引用计数是如何去保护的？
//WeakPtr的实现要点？？？
//https://www.cnblogs.com/wxquare/p/4759020.html
//https://zhuanlan.zhihu.com/p/64543967
#include <iostream>
using namespace std;

template<typename T>
class MySharePtr {
public:
	MySharePtr(T* ptr) : ptr_(ptr) {
		if (ptr) {  //需要做判空
			ref_count_ = new size_t(1);
		}
		else {
			ref_count_ = new size_t(0);
		}
	}

	~MySharePtr() {
		(*ref_count_)--;
		if (*ref_count_ == 0) {
			delete ptr_;
			delete ref_count_;
		}
	}

	//复制构造函数和赋值运算符的区别是对象是否存在，如果对象不存在调用的是复制构造函数，如果对象存在则调用的是赋值运算符
	//复制构造函数
	MySharePtr(const MySharePtr& other_ptr) {
		ptr_ = other_ptr.ptr_;
		ref_count_ = other_ptr.ref_count_;
		ref_count_++;
	}
	//赋值运算符 
	MySharePtr& operator=(const MySharePtr& other_ptr) {
		//需要判断是否和自身相等
		if (this != &other_ptr) {
			//需要对旧对象进行计数减少
			(*ref_count_)--;
			if (*ref_count_ == 0) delete ptr_;
			ptr_ = other_ptr.ptr_;
			ref_count_ = other_ptr.ref_count_;
			ref_count_++;
		}
		return *this;
	}

	//还需要完成解引用操作符和箭头操作符便于使用
	T& operator*() {
		//保证安全，需要判断是否为空
		assert(ptr_);
		return *ptr_;
	}

	T* operator->() {
		assert(ptr_);
		return ptr_;
	}

	size_t Count() {
		return *ref_count_;
	}

private:
	size_t* ref_count_; //必须为指针，否则无法所有拥有相同指针的对象共享
	T* ptr_;
};

//todo weakptr怎么实现？？？
template<typename T>
class MyWeakPtr {
public:

private:
};


int main() {
	cout << "hello world" << endl;
	MySharePtr<int> sp(new int(10));
	system("pause");
	return 0;
}