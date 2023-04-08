import sys
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np


def data_calc (filename):
    data = pd.read_csv(filename)
    year = data['year']
    ice_days = data['GDP']
    plt.plot(year, ice_days)
    plt.xlabel('Year')
    plt.ylabel('GDP (in billions)')
    plt.xticks(range(min(year), max(year)+1, 1))
    plt.savefig('plot.jpg')
    X = np.column_stack((np.ones(len(year), dtype=np.int64), year))
    Y = np.array(ice_days, dtype=np.int64)
    Z = np.dot(X.T, X)
    I = np.linalg.inv(Z)
    PI = np.dot(np.linalg.inv(np.dot(X.T, X)), X.T)
    hat_beta = np.dot(np.linalg.pinv(X), Y)

    x_test = int(input("Enter a future year. The model shall predict the GDP of that year: "))
    y_test = hat_beta[0] + (x_test*hat_beta[1])
    print("Predicted GDP : " + str(y_test))

    x_value = int(input("Enter a GDP (in billions). The model shall predict which year the nation will achieve this: "))
    x_val = (x_value-hat_beta[0]) / hat_beta[1]
    print("Predicted Year : " + str(round(x_val)))

    answer = int(input("Do you wish to see the GDP data visualized? (1 - for yes) (2 - for no): "))
    
    if answer == 1:
        plt.show()
    print()


if __name__ == "__main__":

    print("1) India (Nehruvian Era - Modern Day)")
    print("2) India (Post Economic Liberalization - Modern Day)")
    print("3) Russia (Dissolution of Soviet Union - Modern Day)")
    print("4) Russia (Post-Soviet Union - Modern Day)")
    print("5) USA (20th Century - Modern Day)")
    print("6) China (20th Century - Modern Day)")

    nation = int(input("Current Available Economic Models (select corresponding number or enter quit):"))
    if nation == 1:
        data_calc('indiagdp.csv')
    if nation == 2:
        data_calc('indiapost.csv')
    if nation == 3:
        data_calc('russiagdp.csv')
    if nation == 4:
        data_calc('russiapost.csv')
    if nation == 5:
        data_calc('usagdp.csv')
    if nation == 6:
        data_calc('chinagdp.csv')