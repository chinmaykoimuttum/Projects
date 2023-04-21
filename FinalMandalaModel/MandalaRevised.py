import networkx as nx
import matplotlib.pyplot as plt
import heapq

asia_graph = nx.Graph()


countries = ['India', 'Pakistan', 'Bangladesh', 'Sri Lanka', 
            'Myanmar', 'China', 'Japan', 'Vietnam', 
            'Nepal', 'Bhutan', 'Maldives', 'Iran', 'Afghanistan', 
            'Laos', 'Thailand', 'Cambodia', 'Malaysia', 'Turkmenistan', 
            'Iraq', 'Armenia', 'Azerbaijan', 'Turkey', 'Uzbekistan', 
            'Tajikistan', 'Kazakhstan', 'Kyrgyzstan', 'Russia', 'Mongolia', 
            'North Korea', 'South Korea', 'Taiwan', 'Syria', 'Jordan', 
            'Saudi Arabia', 'Kuwait', 'Yemen', 'Oman', 'United Arab Emirates', 'Qatar', 
            'Israel', 'Bahrain', 'Georgia', 'Cyprus', 'Lebanon', 
            'Indonesia', 'Philippines']

for country in countries:
    asia_graph.add_node(country)

#India
asia_graph.add_edge('India', 'Pakistan')
asia_graph.add_edge('India', 'China')
asia_graph.add_edge('India', 'Bangladesh')
asia_graph.add_edge('India', 'Nepal')
asia_graph.add_edge('India', 'Bhutan')
asia_graph.add_edge('India', 'Myanmar')
asia_graph.add_edge('India', 'Sri Lanka')
asia_graph.add_edge('India', 'Maldives')

#Pakistan
asia_graph.add_edge('Pakistan', 'Iran')
asia_graph.add_edge('Pakistan', 'Afghanistan')
asia_graph.add_edge('Pakistan', 'China')

#Burma
asia_graph.add_edge('Myanmar', 'Bangladesh')
asia_graph.add_edge('Myanmar', 'China')
asia_graph.add_edge('Myanmar', 'Laos')
asia_graph.add_edge('Myanmar', 'Thailand')

#Thailand
asia_graph.add_edge('Thailand', 'Laos')
asia_graph.add_edge('Thailand', 'Cambodia')
asia_graph.add_edge('Thailand', 'Malaysia')

#Vietnam
asia_graph.add_edge('Vietnam', 'Laos')
asia_graph.add_edge('Vietnam', 'Cambodia')
asia_graph.add_edge('Vietnam', 'China')

#Iran
asia_graph.add_edge('Iran', 'Afghanistan')
asia_graph.add_edge('Iran', 'Turkmenistan')
asia_graph.add_edge('Iran', 'Iraq')
asia_graph.add_edge('Iran', 'Armenia')
asia_graph.add_edge('Iran', 'Azerbaijan')
asia_graph.add_edge('Iran', 'Turkey')

#Afghanistan
asia_graph.add_edge('Afghanistan', 'Turkmenistan')
asia_graph.add_edge('Afghanistan', 'Uzbekistan')
asia_graph.add_edge('Afghanistan', 'Tajikistan')
asia_graph.add_edge('Afghanistan', 'China')

#Uzbekistan
asia_graph.add_edge('Uzbekistan', 'Kazakhstan')
asia_graph.add_edge('Uzbekistan', 'Turkmenistan')
asia_graph.add_edge('Uzbekistan', 'Tajikistan')
asia_graph.add_edge('Uzbekistan', 'Kyrgyzstan')

#Kazakhstan
asia_graph.add_edge('Kazakhstan', 'Kyrgyzstan')
asia_graph.add_edge('Kazakhstan', 'Turkmenistan')
asia_graph.add_edge('Kazakhstan', 'China')
asia_graph.add_edge('Kazakhstan', 'Russia')

#Russia
asia_graph.add_edge('Russia', 'Mongolia')
asia_graph.add_edge('Russia', 'China')
asia_graph.add_edge('Russia', 'North Korea')
asia_graph.add_edge('Russia', 'Japan')

#China
asia_graph.add_edge('China', 'Mongolia')
asia_graph.add_edge('China', 'Nepal')
asia_graph.add_edge('China', 'Bhutan')
asia_graph.add_edge('China', 'Myanmar')
asia_graph.add_edge('China', 'Laos')
asia_graph.add_edge('China', 'North Korea')
asia_graph.add_edge('China', 'Kyrgyzstan')
asia_graph.add_edge('China', 'Tajikistan')
asia_graph.add_edge('China', 'Japan')
asia_graph.add_edge('China', 'Taiwan')

#North Korea
asia_graph.add_edge('North Korea', 'South Korea')
asia_graph.add_edge('North Korea', 'Japan')

#Japan
asia_graph.add_edge('Japan', 'South Korea')

#Iraq
asia_graph.add_edge('Iraq', 'Syria')
asia_graph.add_edge('Iraq', 'Jordan')
asia_graph.add_edge('Iraq', 'Saudi Arabia')
asia_graph.add_edge('Iraq', 'Kuwait')
asia_graph.add_edge('Iraq', 'Turkey')

#Yemen
asia_graph.add_edge('Yemen', 'Saudi Arabia')
asia_graph.add_edge('Yemen', 'Oman')

#Oman
asia_graph.add_edge('Oman', 'Saudi Arabia')
asia_graph.add_edge('Oman', 'United Arab Emirates')

#Saudi Arabia
asia_graph.add_edge('Saudi Arabia', 'United Arab Emirates')
asia_graph.add_edge('Saudi Arabia', 'Qatar')
asia_graph.add_edge('Saudi Arabia', 'Kuwait')
asia_graph.add_edge('Saudi Arabia', 'Jordan')
asia_graph.add_edge('Saudi Arabia', 'Israel')
asia_graph.add_edge('Saudi Arabia', 'Bahrain')
asia_graph.add_edge('Saudi Arabia', 'Oman')
asia_graph.add_edge('Saudi Arabia', 'Yemen')

#Turkey
asia_graph.add_edge('Turkey', 'Azerbaijan')
asia_graph.add_edge('Turkey', 'Georgia')
asia_graph.add_edge('Turkey', 'Syria')
asia_graph.add_edge('Turkey', 'Cyprus')

#Georgia
asia_graph.add_edge('Georgia', 'Armenia')
asia_graph.add_edge('Georgia', 'Azerbaijan')
asia_graph.add_edge('Georgia', 'Russia')

#Azerbaijan
asia_graph.add_edge('Azerbaijan', 'Armenia')
asia_graph.add_edge('Azerbaijan', 'Russia')

#Syria
asia_graph.add_edge('Syria', 'Jordan')
asia_graph.add_edge('Syria', 'Lebanon')
asia_graph.add_edge('Syria', 'Israel')

#Lebanon
asia_graph.add_edge('Lebanon', 'Israel')
asia_graph.add_edge('Lebanon', 'Jordan')

#Israel
asia_graph.add_edge('Israel', 'Jordan')

#Maldives
asia_graph.add_edge('Maldives', 'India')
asia_graph.add_edge('Maldives', 'Sri Lanka')

#Malaysia
asia_graph.add_edge('Malaysia', 'Indonesia')
asia_graph.add_edge('Malaysia', 'Philippines')

#Indonesia
asia_graph.add_edge('Indonesia', 'Philippines')

# Set edge attribute for each edge
for u, v in asia_graph.edges:
    asia_graph[u][v]['weight'] = 1


pos = nx.spring_layout(asia_graph)
nx.draw_networkx_nodes(asia_graph, pos)
nx.draw_networkx_edges(asia_graph, pos)
labels = nx.get_edge_attributes(asia_graph,'weight')
nx.draw_networkx_edge_labels(asia_graph, pos, edge_labels=labels)
nx.draw_networkx_labels(asia_graph, pos)

def dijkstra(graph, start):
    distances = {node: float('inf') for node in graph.nodes()}
    visited = {node: False for node in graph.nodes()}
    distances[start] = 0
    queue = [(0, start)]
    while queue:
        _, node = heapq.heappop(queue)
        if visited[node]:
            continue
        visited[node] = True
        for neighbor in graph.neighbors(node):
            distance = distances[node] + graph[node][neighbor]['weight']
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(queue, (distance, neighbor))
    return distances

def single_dijkstra(graph, source, destination):
    distances = {node: float('inf') for node in graph.nodes()}
    visited = {node: False for node in graph.nodes()}
    distances[source] = 0
    queue = [(0, source)]
    while queue:
        _, node = heapq.heappop(queue)
        if visited[node]:
            continue
        visited[node] = True
        if node == destination:
            return distances[destination]
        for neighbor in graph.neighbors(node):
            distance = distances[node] + graph[node][neighbor]['weight']
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(queue, (distance, neighbor))
    return float('inf')

def all_paths(start_node, distances):
    for node, distance in distances.items():
        if distance == 1:
            status = "Natural Enemies"
        if distance == 2:
            status = "Natural Allies"
        if distance != 2 and distance % 2 == 0:
            status = "Natural Rear Allies"
        if distance != 1 and distance % 2 == 1:
            status = "Natural Rear Enemies"
        print(f"Distance from {start_node} to {node}: {status}")

def single_path(start_node, end_node, distances):
    if distances == 1:
        status = "Natural Enemies"
    if distances == 2:
        status = "Natural Allies"
    if distances != 2 and distances % 2 == 0:
        status = "Natural Rear Allies"
    if distances != 1 and distances % 2 == 1:
        status = "Natural Rear Enemies"
    print(f"Distance from {start_node} to {end_node}: {status}")


def edit_relationship(start_node, end_node, status):
    if status == 1:
        asia_graph[start_node][end_node]['weight'] = 1
    if status == 2:
        asia_graph[start_node][end_node]['weight'] = 2

def new_relationship(start_node, end_node, status):
    asia_graph.add_edge(start_node, end_node)
    if status == 1:
        asia_graph[start_node][end_node]['weight'] = 1
    if status == 2:
        asia_graph[start_node][end_node]['weight'] = 2


#plt.show()

#Main Implementation
print("Welcome to the Revised & Final Model of the Mandala Theory!")

quit == False

while quit != True:
    print("Option 0) Quit")
    print("Option 1) Find relationship between one nation with all other nations")
    print("Option 2) Find relationship between one nation with one other nations")
    print("Option 3) Edit relationship between nations [Revised Model Update] ")
    print("Option 4) Create new relationship between nations [Final Model Update] ")
    print("Option 5) Create new nation in map [Final Model Update] ")
    answer = int(input("Enter your option: "))


    if answer == 0:
        quit == True

    if answer == 1:
        start_node = input("Enter nation: ")
        distances = dijkstra(asia_graph, start_node)
        all_paths(start_node, distances)

    if answer == 2:
        start_node = input("Enter nation: ")
        end_node = input("Enter destination nation: ")
        distances = single_dijkstra(asia_graph, start_node, end_node)
        single_path(start_node, end_node, distances)

    if answer == 3:
        print("Nations must be neighbors")
        start_node = input("Enter nation: ")
        end_node = input("Enter destination nation: ")
        status_holder = input("Is the relationship improving [vassalage/unnatural modifiers]? (y if yes, n if no): ")
        if status_holder == "y":
            status = 2
        if status_holder == "n":
            status = 1
        edit_relationship(start_node, end_node, status)

    if answer == 4:
        print("Nations must already exist")
        start_node = input("Enter nation: ")
        end_node = input("Enter destination nation: ")
        status_holder = input("Is the new relationship positive [overcome geographical limitation]? (y if yes, n if no): ")
        if status_holder == "y":
            status = 2
        if status_holder == "n":
            status = 1
        new_relationship(start_node, end_node, status)

    if answer == 5:
        start_node = input("Enter new nation: ")
        end_node = input("Enter destination nation (nation must exit): ")
        countries.append(start_node)
        asia_graph.add_node(start_node)
        status_holder = input("Is the new relationship positive [overcome geographical limitation]? (y if yes, n if no): ")
        if status_holder == "y":
            status = 2
        if status_holder == "n":
            status = 1
        new_relationship(start_node, end_node, status)


    print()
    



