public class Queue_Using_Array{
    public static void main(String[] args) {
        Queue q = new Queue(6);

        q.push(4);
        q.push(14);
        q.push(24);
        q.push(34);

        System.out.println("The peek of the queue before deleting any element " + q.top());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The first element to be deleted is " + q.pop());
        System.out.println("The peek of the element after deleting an element " + q.top());
        System.out.println("The size of the queue after deleting an element " + q.size());
    }
}

class Queue{
    private int arr[];
    private int start, end, currSize, maxSize;

    public Queue(){
        arr = new int[16];
        start = -1;
        end = -1;
        currSize = 0;
    }

    public Queue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        start = -1;
        end = -1;
        currSize = 0;
    }

    public void push(int element){
        if(currSize == maxSize){
            System.out.println("Queue Overflow");
            return;
        }

        if (end == -1) {
            start = 0;
            end = 0;
        }
        else{
            end = (end + 1) % maxSize;
        }

        arr[end] = element;
        System.out.println("The element " + element + " is added to the queue");
        currSize++;
    }

    public int pop(){
        if (start == -1) {
            System.out.println("No element in the queue");
            return -1;
        }

        int popped = arr[start];

        if (currSize == 1) {
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % maxSize;   
        }
        currSize--;
        return popped;
    }

    public int top(){
        if (start == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[start];
    }

    public int size(){
        return currSize;
    }
}