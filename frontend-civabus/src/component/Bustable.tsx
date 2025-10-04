import React from "react";
import type { Bus } from "../models/Bus";

interface BusTableProps {
  buses: Bus[];
}

const BusTable: React.FC<BusTableProps> = ({ buses }) => {
  return (
    <table border={1} cellPadding={6} style={{ borderCollapse: "collapse" }}>
      <thead>
        <tr>
          <th>ID</th>
          <th>Placa</th>
          <th>Número</th>
          <th>Marca</th>
          <th>Características</th>
          <th>Estado</th>
        </tr>
      </thead>
      <tbody>
        {buses.map((bus) => (
          <tr key={bus.idBus}>
            <td>{bus.idBus}</td>
            <td>{bus.placaBus}</td>
            <td>{bus.numeroBus}</td>
            <td>{bus.marcaBus?.nombre}</td>
            <td>{bus.caracteristicaBus}</td>
            <td>{bus.activoBus ? "Activo" : "Inactivo"}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default BusTable;
