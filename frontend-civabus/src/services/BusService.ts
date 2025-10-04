import type { Bus } from "../models/Bus";
import type { PageResponse } from "../models/PageResponse";

const API_URL = "http://localhost:8080/bus";

export const BusService = {
  getAll: async (page = 0, field?: string, desc?: boolean): Promise<PageResponse<Bus>> => {
    let url = `${API_URL}?page=${page}`;
    if (field) url += `&field=${field}`;
    if (desc !== undefined) url += `&desc=${desc}`;

    const res = await fetch(url);
    if (!res.ok) throw new Error(`Error ${res.status} al obtener buses`);
    return (await res.json()) as PageResponse<Bus>;
  },

  getById: async (id: number): Promise<Bus> => {
    const res = await fetch(`${API_URL}/${id}`);
    if (!res.ok) throw new Error(`Bus con id ${id} no encontrado`);
    return (await res.json()) as Bus;
  },
};
