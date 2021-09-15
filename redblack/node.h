#pragma once

namespace rb {
    enum class Color {
        BLACK,
        RED
    };

    template<typename T>
    class Node {
        virtual T val() const = 0;
    };

    namespace impl {


        template<typename T>
        class RBNode : Node<T>{
        public:

        // CONSTRUCTORS

            RBNode(T value, Color color, RBNode<T>* left_child = nullptr, RBNode<T>* right_child = nullptr) {
                _val = value;
                _color = color;

                _l_c = left_child;
                _r_c = right_child;
            }

        // GETTERS

            T val() const override {
                return _val;
            }
            Color color() const {
                return _color;
            }
            void setColor(Color c) {
                _color = c;
            }

        // TREE FUNCTIONS

            RBNode<T>* left() {
                return _l_c;
            }
            RBNode<T>* right() {
                return _r_c;
            }
            unsigned int blackHeight() const {
                typedef unsigned int ul;

                ul l = 0;
                ul r = 0;

                if (_l_c == nullptr || _l_c->_color == Color::BLACK)
                    l++;
                if (_r_c == nullptr || _r_c->_color == Color::BLACK)
                    r++;

                if (_l_c != nullptr) 
                    l += blackHeight(_l_c);
                if (_r_c != nullptr) 
                    r += blackHeight(_r_c);

                return (l > r) ? l : r;
            }

        private:
            T _val;
            Color _color;

            RBNode<T>* _l_c;
            RBNode<T>* _r_c;
        };


    }
}