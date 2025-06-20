export type Tetromino =
  | {
      shape: "I";
      color: "red";
    }
  | {
      shape: "O";
      color: "blue";
    }
  | {
      shape: "T";
      color: "green";
    }
  | {
      shape: "S";
      color: "pink";
    }
  | {
      shape: "Z";
      color: "yellow";
    }
  | {
      shape: "J";
      color: "purple";
    }
  | {
      shape: "L";
      color: "grey";
    };
