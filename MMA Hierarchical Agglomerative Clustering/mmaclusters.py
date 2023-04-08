import numpy as np
import matplotlib.pyplot as plt
import csv
from scipy.cluster.hierarchy import dendrogram


def load_data(filename):
  X = []
  with open(filename) as file_obj:
    reader_obj = csv.DictReader(file_obj)
    for row in reader_obj:
        X.append(dict(row))
  return X

def calc_features(row):
  x1 = row['SLpM']
  x2 = row['Str_Acc']
  x3 = row['SApM']
  x4 = row['Str_Def']
  x5 = row['TD_Avg']
  x6 = row['TD_Acc']
  x7 = row['TD_Def']
  x8 = row['Sub_Avg']
  row_array = np.array([x1,x2,x3,x4,x5,x6,x7,x8])
  return row_array.astype('int64')


def hac(features):
  def distance_matrix(features):
    n = len(features)
    arr = np.array(features)  
    comp1 = (np.sum(arr**2, axis=1)).reshape(n,1)
    comp2 = (np.sum(arr**2, axis=1)).reshape(n,)
    comp3 = (2 * (arr.dot(np.transpose(arr))))
    D = comp1 + comp2 - comp3
    return np.sqrt(D)
  values = dict()
  range_val = len(features)
  D = distance_matrix(features)
  for label in range(range_val): 
    values[label] = [label]
  min_dist = np.inf
  range_val = len(features)
  Z = np.empty([0,4])
  clusters_track = {}
  for i in range(range_val):
    key = i
    clusters_track[key] = []

  new_length = len(features)
  for n in range(new_length - 1): 
    min_dist = np.inf 
    c1 = 0
    c2 = 0
    for i in values: 
      for j in values:
          if i == j: 
            continue
          complete_max = -np.inf
          cluster_i = values[i] 
          cluster_j = values[j]
          for a in cluster_i: 
            for b in cluster_j:
              if complete_max < D[a][b]: 
                complete_max = D[a][b]
          if min_dist > complete_max:  
              min_dist = complete_max
              c1 =  i
              c2 = j
          elif complete_max == min_dist: 
              if c1 > i:
                c1 =  i
                c2 = j
              elif c1 == i:
                if c2 > j:
                  c2 = j
    values[new_length] = values[c1] + values[c2] 
    del values[c1]
    del values[c2]
    new_row = [c1, c2, min_dist, len(values[new_length])]
    Z = np.vstack((Z, new_row))
    new_length = new_length +1
  return Z


def imshow_hac(Z, names):
  plt.title("N = " + str(len(Z)+1) + " MMA Fighters Clustering")
  dendrogram(Z, leaf_rotation=90., leaf_font_size=8., labels=names)
  plt.tight_layout()
  plt.show()



if __name__ == '__main__':
    n = int(input("Enter size of n: "))
    data = load_data('raw_fighter_details.csv')
    features_and_names = [(calc_features(row), row['fighter_name']) for row in data[:n]]
    Z = hac([row[0] for row in features_and_names])
    names = [row[1] for row in features_and_names]
    imshow_hac(Z, names)