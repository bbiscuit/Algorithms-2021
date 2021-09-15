#pragma once

#include "node.h"

namespace rb {

    template<typename T>
    class RedBlackTree {
    public:

        Node<T>* root() {
            return (Node<T>*)root;
        }

    private:

        impl::RBNode<T>* root;

    };

}