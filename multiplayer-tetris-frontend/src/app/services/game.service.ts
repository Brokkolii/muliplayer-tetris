import { Injectable } from "@angular/core";
import { Game } from "../models/game.type";
import { Tetromino } from "../models/tetromino.type";
import { Piece } from "../models/piece.type";

@Injectable({
  providedIn: "root",
})
export class GameService {
  constructor() {}

  game: Game | null = null;

  createGame() {
    this.game = {
      board: {
        staticFields: [],
        fallingPiece: this.getNextPiece(),
      },
    };
  }

  getNextPiece(): Piece {
    const nextTetromino = this.getNextTetromino();
    // if (nextTetromino.shape === "L") {
    return {
      type: nextTetromino,
      row: 24,
      column: 4,
      fields: [
        [false, true, false],
        [false, true, false],
        [false, true, true],
      ],
    };
    // }
  }

  getNextTetromino(): Tetromino {
    // TODO: make random or get from server
    return {
      shape: "L",
      color: "grey",
    };
  }
}
