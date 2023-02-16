from scipy.linalg import eigh
import numpy as np
import matplotlib.pyplot as plt

def load_and_center_dataset(filename):
    x = np.load(filename)
    x = x - np.mean(x, axis = 0)
    return x
    
    # Your implementation goes here!
    pass

def get_covariance(dataset):
    # Your implementation goes here!
    return (1 /(len(dataset)-1))*np.dot(np.transpose(dataset), dataset)
    pass

def get_eig(S, m):
    # Your implementation goes here!
    x, y = eigh(S, subset_by_index=[len(S) - m, len(S) - 1])
    x[::-1].sort()
    #y[::-1].sort()
    x = np.diag(x)
    for i in range(len(y)):
        y[i] = y[i][::-1]
    return x, y
    pass

def get_eig_prop(S, prop):
    # Your implementation goes here!

    x = eigh(S, eigvals_only=True, subset_by_value=[-np.inf, np.inf])
    x[::-1].sort()

    eig_j = 0
    for j in range(len(x)):
        eig_j = eig_j + x[j]

    A = []

    for i in range(len(x)):
        if ((x[i]/eig_j) > prop):
            A.append(x[i])
    A.sort()
 
    a, b = eigh(S, subset_by_value=[A[0], np.inf])

    #for i in range(len(S)):
    a[::-1].sort()
    #y[::-1].sort()
    a = np.diag(a)
    for i in range(len(b)):
        b[i] = b[i][::-1]
    return a, b

def project_image(image, U):
    # Your implementation goes here!
    A = []
    x = (np.transpose(U)).dot(image)
    for i in range(len(U)):
        A.append(x.dot(U[i]))

    A = np.array(A)
    return A
    pass

def display_image(orig, proj):
    # Your implementation goes here!

    o = orig.reshape(32,32)
    p = proj.reshape(32,32)

    fig,(ax1,ax2) = plt.subplots(1,2)
    
    ax1.set_title('Original')
    ax2.set_title('Projection')
    fig.colorbar(ax1.imshow(np.transpose(o),aspect='equal'), ax=ax1)
    fig.colorbar(ax2.imshow(np.transpose(p),aspect='equal'), ax=ax2)
    plt.show()
    pass


