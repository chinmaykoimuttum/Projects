import heapq
class Vertex:
    def __init__(self, val):
        self.value = val
        self.edges = []
        self.distance = float('inf')
        self.visited = False
        self.previous = None

    def __lt__(self, other):
        return self.distance < other.distance

class Edge:
    def __init__(self, val, v1, v2):
        self.value = val
        self.vertex1 = v1
        self.vertex2 = v2
        v1.edges.append(self)
        v2.edges.append(self)

class Graph:
    def __init__(self, vertices=[], edges=[]):
        self.vertices = vertices
        self.edges = edges

    def insert_vertex(self, val):
        vertex = Vertex(val)
        self.vertices.append(vertex)
        return vertex

    def insert_edge(self, val, v1, v2):
        edge = Edge(val, v1, v2)
        self.edges.append(edge)
        v1.edges.append(edge)
        v2.edges.append(edge)


def dijkstra(graph, start):
    for vertex in graph.vertices:
        vertex.distance = float('inf')
    start.distance = 0
    pq = [(0, start)]

    while len(pq) > 0:
        current_distance, current_vertex = heapq.heappop(pq)

        if current_distance > current_vertex.distance:
            continue

       
        for edge in current_vertex.edges:
            neighbor = edge.vertex1 if edge.vertex2 == current_vertex else edge.vertex2
            tentative_distance = current_distance + edge.value
            if tentative_distance < neighbor.distance:
                neighbor.distance = tentative_distance
                heapq.heappush(pq, (tentative_distance, neighbor))
    return {vertex.value: vertex.distance for vertex in graph.vertices}

def full_map(asia_graph, india):
    dijkstra(asia_graph, india)
    for vertex in asia_graph.vertices:
        if vertex.distance != 2 and vertex.distance % 2 == 0:
            status = " -> natural rear ally"
        if vertex.distance != 1 and vertex.distance % 2 == 1:
            status = " -> natural rear enemy"
        if vertex.distance == 2 and vertex.distance % 2 == 0:
            status = " -> natural ally"
        if vertex.distance == 1 and vertex.distance % 2 == 1:
            status = " -> natural enemy"
        print(vertex.value, status)


def shortest_path(asia_graph, source, destination):
    dijkstra(asia_graph, source)
    for vertex in asia_graph.vertices:
        if destination == vertex.value:
            distance = vertex.distance
    return distance


def path_finder(graph, source, end):
    for vertex in graph.vertices:
        vertex.distance = float('inf')
    source.distance = 0
    pq = [(0, source)]

    while len(pq) > 0:
        current_distance, current_vertex = heapq.heappop(pq)
        if current_distance > current_vertex.distance:
            continue
        for edge in current_vertex.edges:
            neighbor = edge.vertex1 if edge.vertex2 == current_vertex else edge.vertex2
            tentative_distance = current_distance + edge.value
            if tentative_distance < neighbor.distance:
                neighbor.distance = tentative_distance
                neighbor.previous = current_vertex
                heapq.heappush(pq, (tentative_distance, neighbor))
    shortest_paths = []
    for vertex in graph.vertices:
        path = [vertex.value]
        current = vertex
        while current.previous is not None:
            path.insert(0, current.previous.value)
            current = current.previous
        if path[-1] == end:
            shortest_paths.append(path)

    return shortest_paths


asia_graph = Graph()
india = asia_graph.insert_vertex('India')
pak = asia_graph.insert_vertex('Pakistan')
Bangladesh = asia_graph.insert_vertex('Bangladesh')
srilanka = asia_graph.insert_vertex('Sri Lanka')
myanmar = asia_graph.insert_vertex('Myanmar')
china = asia_graph.insert_vertex('China')
japan = asia_graph.insert_vertex('Japan')
vietnam = asia_graph.insert_vertex('Vietnam')
nepal = asia_graph.insert_vertex('Nepal')
bhutan = asia_graph.insert_vertex('Bhutan')
maldives = asia_graph.insert_vertex('Maldives')
iran = asia_graph.insert_vertex('Iran')
afghan = asia_graph.insert_vertex('Afghanistan')
laos = asia_graph.insert_vertex('Laos')
thailand = asia_graph.insert_vertex('Thailand')
cambodia = asia_graph.insert_vertex('Cambodia')
malay = asia_graph.insert_vertex('Malaysia')
turkmenistan = asia_graph.insert_vertex('Turkmenistan')
iraq = asia_graph.insert_vertex('Iraq')
armenia = asia_graph.insert_vertex('Armenia')
azer = asia_graph.insert_vertex('Azerbaijan')
turkey = asia_graph.insert_vertex('Turkey')
uzbek = asia_graph.insert_vertex('Uzbekistan')
tajik = asia_graph.insert_vertex('Tajikistan')
kazakh = asia_graph.insert_vertex('Kazakhstan')
kyrg = asia_graph.insert_vertex('Kyrgyzstan')
russia = asia_graph.insert_vertex('Russia')
mongolia = asia_graph.insert_vertex('Mongolia')
nkorea = asia_graph.insert_vertex('North Korea')
skorea = asia_graph.insert_vertex('South Korea')
taiwan = asia_graph.insert_vertex('Taiwan')
syria = asia_graph.insert_vertex('Syria')
jordan = asia_graph.insert_vertex('Jordan')
saudi = asia_graph.insert_vertex('Saudi Arabia')
kuwait = asia_graph.insert_vertex('Kuwait')
yemen = asia_graph.insert_vertex('Yemen')
oman = asia_graph.insert_vertex('Oman')
uae = asia_graph.insert_vertex('UAE')
qatar = asia_graph.insert_vertex('Qatar')
israel = asia_graph.insert_vertex('Israel')
bahrain = asia_graph.insert_vertex('Bahrain')
georgia = asia_graph.insert_vertex('Georgia')
cyprus = asia_graph.insert_vertex('Cyprus')
leban = asia_graph.insert_vertex('Lebanon')
indonesia = asia_graph.insert_vertex('Indonesia')
philip = asia_graph.insert_vertex('Philippines')

#India
asia_graph.insert_edge(1, india, pak)
asia_graph.insert_edge(1, india, china)
asia_graph.insert_edge(1, india, Bangladesh)
asia_graph.insert_edge(1, india, nepal)
asia_graph.insert_edge(1, india, bhutan)
asia_graph.insert_edge(1, india, myanmar)
asia_graph.insert_edge(1, india, srilanka)
asia_graph.insert_edge(1, india, maldives)

#Pakistan
asia_graph.insert_edge(1, pak, iran)
asia_graph.insert_edge(1, pak, afghan)
asia_graph.insert_edge(1, pak, china)

#Burma
asia_graph.insert_edge(1, myanmar, Bangladesh)
asia_graph.insert_edge(1, myanmar, china)
asia_graph.insert_edge(1, myanmar, laos)
asia_graph.insert_edge(1, myanmar, thailand)
asia_graph.insert_edge(1, myanmar, china)

#Thailand
asia_graph.insert_edge(1, thailand, laos)
asia_graph.insert_edge(1, thailand, cambodia)
asia_graph.insert_edge(1, thailand, malay)

#vietnam
asia_graph.insert_edge(1, vietnam, laos)
asia_graph.insert_edge(1, vietnam, cambodia)
asia_graph.insert_edge(1, vietnam, china)

#Iran
asia_graph.insert_edge(1, iran, afghan)
asia_graph.insert_edge(1, iran, turkmenistan)
asia_graph.insert_edge(1, iran, iraq)
asia_graph.insert_edge(1, iran, armenia)
asia_graph.insert_edge(1, iran, azer)
asia_graph.insert_edge(1, iran, turkey)

#Afghanistan
asia_graph.insert_edge(1, afghan, turkmenistan)
asia_graph.insert_edge(1, afghan, uzbek)
asia_graph.insert_edge(1, afghan, tajik)
asia_graph.insert_edge(1, afghan, china)

#Uzbekistan
asia_graph.insert_edge(1, uzbek, kazakh)
asia_graph.insert_edge(1, uzbek, turkmenistan)
asia_graph.insert_edge(1, uzbek, tajik)
asia_graph.insert_edge(1, uzbek, kyrg)

#Tajikistan
asia_graph.insert_edge(1, tajik, kyrg)

#Kazakhstan
asia_graph.insert_edge(1, kazakh, kyrg)
asia_graph.insert_edge(1, kazakh, turkmenistan)
asia_graph.insert_edge(1, kazakh, china)
asia_graph.insert_edge(1, kazakh, russia)

#Russia
asia_graph.insert_edge(1, russia, mongolia)
asia_graph.insert_edge(1, russia, china)
asia_graph.insert_edge(1, russia, nkorea)
asia_graph.insert_edge(1, russia, japan)

#China
asia_graph.insert_edge(1, china, mongolia)
asia_graph.insert_edge(1, china, nepal)
asia_graph.insert_edge(1, china, bhutan)
asia_graph.insert_edge(1, china, myanmar)
asia_graph.insert_edge(1, china, laos)
asia_graph.insert_edge(1, china, nkorea)
asia_graph.insert_edge(1, china, kyrg)
asia_graph.insert_edge(1, china, tajik)
asia_graph.insert_edge(1, china, laos)
asia_graph.insert_edge(1, china, japan)
asia_graph.insert_edge(1, china, taiwan)

#North Korea
asia_graph.insert_edge(1, nkorea, skorea)
asia_graph.insert_edge(1, nkorea, japan)

#Japan
asia_graph.insert_edge(1, skorea, japan)

#Iraq
asia_graph.insert_edge(1, iraq, syria)
asia_graph.insert_edge(1, iraq, jordan)
asia_graph.insert_edge(1, iraq, syria)
asia_graph.insert_edge(1, iraq, saudi)
asia_graph.insert_edge(1, iraq, kuwait)
asia_graph.insert_edge(1, iraq, turkey)

#Yemen
asia_graph.insert_edge(1, yemen, saudi)
asia_graph.insert_edge(1, yemen, oman)

#Oman
asia_graph.insert_edge(1, oman, saudi)
asia_graph.insert_edge(1, oman, uae)

#Saudi Arabia
asia_graph.insert_edge(1, saudi, uae)
asia_graph.insert_edge(1, saudi, uae)
asia_graph.insert_edge(1, saudi, qatar)
asia_graph.insert_edge(1, saudi, kuwait)
asia_graph.insert_edge(1, saudi, jordan)
asia_graph.insert_edge(1, saudi, israel)
asia_graph.insert_edge(1, saudi, bahrain)

#Turkey
asia_graph.insert_edge(1, turkey, azer)
asia_graph.insert_edge(1, turkey, georgia)
asia_graph.insert_edge(1, turkey, syria)
asia_graph.insert_edge(1, turkey, cyprus)

#Georgia
asia_graph.insert_edge(1, georgia, armenia)
asia_graph.insert_edge(1, georgia, azer)
asia_graph.insert_edge(1, georgia, russia)

#Azerbaijan
asia_graph.insert_edge(1, azer, armenia)
asia_graph.insert_edge(1, azer, russia)

#Syria
asia_graph.insert_edge(1, syria, jordan)
asia_graph.insert_edge(1, syria, leban)
asia_graph.insert_edge(1, syria, israel)

#Lebanon
asia_graph.insert_edge(1, leban, israel)
asia_graph.insert_edge(1, leban, jordan)

#Israel
asia_graph.insert_edge(1, israel, jordan)

#Maldives
asia_graph.insert_edge(1, maldives, india)
asia_graph.insert_edge(1, maldives, srilanka)

#Malaysia
asia_graph.insert_edge(1, malay, indonesia)
asia_graph.insert_edge(1, malay, philip)

#Indonesia
asia_graph.insert_edge(1, indonesia, philip)




quit = False
while quit != True:
    print()
    print("Enter 1: See Vijigishu (Conquerer) country in relation with EVERY nation")
    print("Enter 2: See Vijigishu (Conquerer) country in relation with ANOTHER SPECIFIC nation")
    print("Enter 3: Quit/Exit")
    print()

    user_input = int(input("Enter option number (type '3' to exit): "))

    if user_input == 3:
        quit = True


    if user_input == 1:
        nation_name = input("Enter Vijigishu (Conquerer) country: ")
        nation_vertex = None
        for vertex in asia_graph.vertices:
            if vertex.value == nation_name:
                nation_vertex = vertex
                break

        if nation_vertex is not None:
            full_map(asia_graph, nation_vertex)
        else:
            print("Nation vertex not found!")

    if user_input == 2:
        nation_name = input("Enter Vijigishu (Conquerer) country: ")
        nation_vertex = None
        for vertex_src in asia_graph.vertices:
            if vertex_src.value == nation_name:
                nation_vertex = vertex_src
                break

        nation_dest = input("Enter Destination country: ")
        nation_vertex_dest = None
        for vertex_dest in asia_graph.vertices:
            if vertex_dest.value == nation_dest:
                nation_vertex_dest = vertex_dest
                break

        if nation_vertex and nation_dest is not None:
            print()
            dist_final = shortest_path(asia_graph, nation_vertex, nation_dest)
            print("Source: ",nation_vertex.value)
            print("Destination: ",nation_dest)
            path = path_finder(asia_graph, nation_vertex, nation_dest)

            for items in path:    
                print("Linear circle of states: ",path)
            print()

            if dist_final != 2 and dist_final % 2 == 0:
                print(nation_dest, "is",nation_vertex.value,"'s natural rear ally")
            if dist_final != 1 and dist_final % 2 == 1:
                print(nation_dest, "is",nation_vertex.value,"'s natural rear enemy")
            if dist_final == 2 and dist_final % 2 == 0:
                print(nation_dest, "is",nation_vertex.value,"'s natural ally")
            if dist_final == 1 and dist_final % 2 == 1:
                print(nation_dest, "is",nation_vertex.value,"'s natural enemy")
        else:
            print("Nation vertex not found!")

    




