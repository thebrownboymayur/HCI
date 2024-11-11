from tkinter import *

def calculate(op):
    try:
        num1, num2 = int(t1.get()), int(t2.get())
        if op == 'add': result = num1 + num2
        elif op == 'sub': result = num1 - num2
        elif op == 'mul': result = num1 * num2
        elif op == 'div': result = num1 / num2 if num2 != 0 else 'Error'
        t3.delete(0, 'end')
        t3.insert(END, str(result))
    except: 
        t3.delete(0, 'end')  
        t3.insert(END, 'Error')  

window = Tk()
window.geometry("400x300")

# Entry fields and buttons
t1, t2, t3 = Entry(window), Entry(window), Entry(window)
Label(window, text='First number').place(x=50, y=50)
t1.place(x=150, y=50)
Label(window, text='Second number').place(x=50, y=100)
t2.place(x=150, y=100)
Label(window, text='Result').place(x=50, y=200)
t3.place(x=150, y=200)

# Buttons for operations (without using loop)
Button(window, text='Add', command=lambda: calculate('add')).place(x=50, y=150)
Button(window, text='Subtract', command=lambda: calculate('sub')).place(x=150, y=150)
Button(window, text='Multiply', command=lambda: calculate('mul')).place(x=250, y=150)
Button(window, text='Divide', command=lambda: calculate('div')).place(x=350, y=150)

window.mainloop()
