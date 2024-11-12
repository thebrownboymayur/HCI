from tkinter import *
from functools import partial

def validateLogin(username, password):
    print("username entered :", username.get())
    print("password entered :", password.get())
    lognSucess = Label(tkWindow, text="Login Successful")
    lognSucess.grid(row=5, column=0)
    return

def clearLogin(username, password):
    usernameEntry.delete(0, 'end')
    passwordEntry.delete(0, 'end')
    return

# Initialize window
tkWindow = Tk()
tkWindow.geometry('400x150')
tkWindow.title('Welcome to Login Form')

# Username label and text entry box
usernameLabel = Label(tkWindow, text="User Name")
usernameLabel.grid(row=0, column=0)
username = StringVar()
usernameEntry = Entry(tkWindow, textvariable=username)
usernameEntry.grid(row=0, column=1)

# Password label and password entry box
passwordLabel = Label(tkWindow, text="Password")
passwordLabel.grid(row=1, column=0)
password = StringVar()
passwordEntry = Entry(tkWindow, textvariable=password, show='*')
passwordEntry.grid(row=1, column=1)

# Partial functions for buttons
validateLogin = partial(validateLogin, username, password)
clearLogin = partial(clearLogin, username, password)

# Login and Clear buttons
loginButton = Button(tkWindow, text="Login", command=validateLogin)
loginButton.grid(row=4, column=0)

cancelButton = Button(tkWindow, text="Clear", command=clearLogin)
cancelButton.grid(row=4, column=1)

tkWindow.mainloop()
