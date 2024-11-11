from tkinter import *

def validateLogin(username, password):
    print(f"username entered: {username.get()}")
    print(f"password entered: {password.get()}")
    Label(tkWindow, text="Login Successful").grid(row=5, column=0)

def clearLogin(username, password):
    username.delete(0, 'end')
    password.delete(0, 'end')

tkWindow = Tk()
tkWindow.geometry('400x150')

# Labels for Username and Password
Label(tkWindow, text="User Name").grid(row=0, column=0)
Label(tkWindow, text="Password").grid(row=1, column=0)

# Username and Password Entry
username, password = StringVar(), StringVar()
Entry(tkWindow, textvariable=username).grid(row=0, column=1)
Entry(tkWindow, textvariable=password, show='*').grid(row=1, column=1)

# Buttons with partial functions
Button(tkWindow, text="Login", command=lambda: validateLogin(username, password)).grid(row=4, column=0)
Button(tkWindow, text="Clear", command=lambda: clearLogin(username, password)).grid(row=4, column=1)

tkWindow.mainloop()
