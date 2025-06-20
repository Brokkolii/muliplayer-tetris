import { Piece } from "./piece.type";

export type Board = {
  staticFields: {
    row: number;
    coloumn: number;
    color: string;
  }[];
  fallingPiece: Piece;
};
