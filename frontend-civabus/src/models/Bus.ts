import type { Marca } from "./Marca";

export interface Bus {
  idBus: number;
  marcaBus: Marca;
  placaBus: string;
  numeroBus: string;
  caracteristicaBus: string;
  activoBus: boolean;
  fechaCreacionBus: string;
}
