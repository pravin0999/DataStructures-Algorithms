# A Program to implement a Linked List DataStructure

class node:
    def __init__(self):
        self.data = None # contains the data
        self.next = None # contains the reference to the next node


class linked_list:
    def __init__(self):
        self.cur_node = None

    def addNodeAtBeginning(self, data):
        new_node = node() # create a new node
        new_node.data = data
        new_node.next = self.cur_node # link the new node to the 'previous' node.
        self.cur_node = new_node #  set the current node to the new one.

    def addNodeAtPosition(self, data, position):
    	new_node = node()
    	new_node.data = data
    	new_node.next = None
    	if(position == 1):
    		new_node.next = self.cur_node
    		self.cur_node = new_node
		temp = self.cur_node
		for i in range(0,position):
			temp = temp.next
		new_node.next = temp.next
		temp.next = new_node
    	


    def list_print(self):
        node = self.cur_node # cant point to ll!
        while node:
            print node.data
            node = node.next



ll = linked_list()
ll.addNodeAtPosition(1, 1)
ll.addNodeAtPosition(2, 2)
ll.addNodeAtPosition(3, 3)

ll.list_print()