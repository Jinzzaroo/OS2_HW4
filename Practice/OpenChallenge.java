package Practice;

import java.util.Scanner;

abstract class GameObject {
    protected int distance;
    protected int x, y;
    public GameObject(int startX, int startY, int distance) {
        this.x = startX;
        this.y = startY;
        this.distance = distance;
    }
    
    public int getX() {return x;}
    public int getY() {return y;}
    public boolean collide(GameObject p) {
        if(this.x == p.getX() && this.y == p.getY())
            return true;
        else
            return false;
    }
    protected abstract void move();
    protected abstract char getShape();
}
 
public class OpenChallenge {
 
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.set();
        frame.run();
    }
 
}
 
class Bear extends GameObject{
    public Bear(int startX, int startY, int distance) {
        super(startX, startY, distance);
        // TODO Auto-generated constructor stub
    }
 
    @Override
    protected void move() {
        Scanner sc_B = new Scanner(System.in);
        System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >>");
        String trig = sc_B.next();
        
        switch(trig) {
        case "a":
            Frame.map[y][x] = '-';
            x -= distance;
            Frame.map[y][x] = getShape();
            break;
        case "s":
            Frame.map[y][x] = '-';
            y += distance;
            Frame.map[y][x] = getShape();
            break;
        case "d":
            Frame.map[y][x] = '-';
            y += distance;
            Frame.map[y][x] = getShape();
            break;
        case "f":
            Frame.map[y][x] = '-';
            x += distance;
            Frame.map[y][x] = getShape();
            break; 
        }
 
    }
 
    @Override
    protected char getShape() {
        return 'B';
    }
    
}
class Fish extends GameObject{
    
    public Fish(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }
 
    @Override
    protected void move() {
        switch((int)(Math.random()*3)) {
        case 0:
            if(x==0) {
                Frame.map[y][x] = getShape();
            }else {
                Frame.map[y][x] = '-';
                x -= distance;
                Frame.map[y][x] = getShape();
            }
            break;
        case 1:
            if(y==9) {
                Frame.map[y][x] = getShape();
            }else {
                Frame.map[y][x] = '-';
                y += distance;
                Frame.map[y][x] = getShape();
            }
            break;
        case 2:
            if(y==19) {
                Frame.map[y][x] = getShape();
            }else {
                Frame.map[y][x] = '-';
                y += distance;
                Frame.map[y][x] = getShape();
            }
            break;
        case 3:
            if(x==9) {
                Frame.map[y][x] = getShape();
            }else {
                Frame.map[y][x] = '-';
                x += distance;
                Frame.map[y][x] = getShape();
            }
            break; 
        }
    }
    @Override
    protected char getShape() {
        return '@';
    }
 
 
    
    
}
 
class Frame{
    static char[][] map = new char[10][20];
    Bear bear = new Bear(0,0,1);
    Fish fish = new Fish(5,5,1);
    
    public void set(){
        for(int i=0;i<10;i++) {
            for(int e=0;e<20;e++) {
                map[i][e] = '-';
            }
        }
        map[0][0] = bear.getShape();
        map[5][5] = fish.getShape();
    }
    
    public void printMap() {
        for(int i=0;i<10;i++) {
            for(int e=0;e<20;e++) {
                System.out.print(map[i][e]);
            }
            System.out.println();
        }
    }
    
    public void run() {
        set();
        System.out.println("**Bear의 fish 먹기 게임을 시작합니다.**");
        int fish_move = 0;
        int total_move = 0;
        printMap();
        boolean flag = true;
        while(flag) {
            bear.move();
            int r = (int)(Math.random()*2);
            if(total_move ==5) {
                fish_move =0;
                total_move =0;
            }
            if(r ==0 && fish_move<2) {
                System.out.println(r);
                printMap();
                fish.move();
                fish_move+=1;
                total_move+=1;
            }else if(r ==1 && total_move>3 && fish_move<2) {
                fish.move();
                printMap();
                fish_move+=1;
                total_move+=1;
            }else {
                printMap();
                total_move+=1;
            }

            if(bear.collide(fish)) {
                printMap();
                System.out.println("Bear Wins!!");
                flag = false;
            }
        }
    }
}
