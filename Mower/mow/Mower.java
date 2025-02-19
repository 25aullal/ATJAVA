package mow;

public class Mower {
    private int row;
    private int column;
    private int direction;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void moveForward() {
        if (direction == 0) {
            row--;
        } else if (direction == 1) {
            column++;
        } else if (direction == 2) {
            row++;
        } else if (direction == 3) {
            column--;
        }
    }

    public void turnRight() {
        if (direction == 3) {
            direction = 0;
        } else {
            direction++;
        }
    }

    public void turnLeft() {
        if (direction == 0) {
            direction = 3;
        } else {
            direction--;
        }
    }

    public char detectForward(Yard yard) {
        if (direction == 0) {
            return yard.yardGetter(column, row - 1);
        } else if (direction == 1) {
            return yard.yardGetter(column + 1, row);
        } else if (direction == 2) {
            return yard.yardGetter(column, row + 1);
        } else {
            return yard.yardGetter(column - 1, row);
        }
    }

    public void mowUnderneath(Yard yard) {
        yard.mowTile(column, row);
    }

    public void randomSet(Yard yard) {
        int randomSpot = (int) (4 * Math.random());
        if (randomSpot == 0) {
            setRow(1);
            setColumn(1);
        } else if (randomSpot == 1) {
            setRow(1);
            setColumn(yard.widthGetter());
        } else if (randomSpot == 2) {
            setRow(yard.heightGetter());
            setColumn(1);
        } else {
            setRow(yard.heightGetter());
            setColumn(yard.widthGetter());
        }

        int randomDir = (int) (4 * Math.random());
        direction = randomDir;
    }

    public boolean updateMower(Yard yard) {
        for (int i = 1; i <= yard.heightGetter(); i++) {
            for (int j = 1; j <= yard.widthGetter(); j++) {
                if (yard.yardGetter(j, i) == '+') {
                    return false;
                }
            }
        }
        return true;
    }

    public char detectBackward(Yard yard) {
        if (direction == 0) {
            return yard.yardGetter(column, row + 1);
        } else if (direction == 1) {
            return yard.yardGetter(column - 1, row);
        } else if (direction == 2) {
            return yard.yardGetter(column, row - 1);
        } else {
            return yard.yardGetter(column + 1, row);
        }
    }

    public char detectRight(Yard yard) {
        if (direction == 0) {
            return yard.yardGetter(column + 1, row);
        } else if (direction == 1) {
            return yard.yardGetter(column, row + 1);
        } else if (direction == 2) {
            return yard.yardGetter(column - 1, row);
        } else {
            return yard.yardGetter(column, row - 1);
        }
    }

    public char detectLeft(Yard yard) {
        if (direction == 0) {
            return yard.yardGetter(column - 1, row);
        } else if (direction == 1) {
            return yard.yardGetter(column, row - 1);
        } else if (direction == 2) {
            return yard.yardGetter(column + 1, row);
        } else {
            return yard.yardGetter(column, row + 1);
        }
    }

}