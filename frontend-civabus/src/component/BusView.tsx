import React, { useEffect, useState } from "react";
import type { Bus } from "../models/Bus";
import type { PageResponse } from "../models/PageResponse";
import { BusService } from "../services/BusService";
import BusTable from "./Bustable";
import Pagination from "./Pagination";

const BusView: React.FC = () => {
  const [page, setPage] = useState<PageResponse<Bus> | null>(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [currentPage, setCurrentPage] = useState(0);
  const [searchId, setSearchId] = useState("");

  useEffect(() => {
    setLoading(true);
    BusService.getAll(currentPage, "id", false)
      .then((p) => setPage(p))
      .catch((e) => setError((e as Error).message))
      .finally(() => setLoading(false));
  }, [currentPage]);

  useEffect(() => {
    setLoading(true);

    BusService.getAll(currentPage, "id", false)
      .then((p) => setPage(p))
      .catch((e) => setError((e as Error).message))
      .finally(() => setLoading(false));
  }, [currentPage]);

  const handleSearch = async () => {
    if (!searchId) {
      alert("Ingresa un ID");

      return;
    }

    try {
      const bus = await BusService.getById(Number(searchId));

      alert(`Bus encontrado:\nID=${bus.idBus}\nPlaca=${bus.placaBus}\nNúmero=${bus.numeroBus}`);
    } catch (err: any) {
      alert(err.message || "Error al buscar bus");
    }
  };

  if (loading) return <p style={{ textAlign: "center" }}>Cargando...</p>;
  if (error) return <p style={{ textAlign: "center" }}>Error: {error}</p>;

  return (
    <div className="container" style={{ display: "flex", flexDirection: "column", alignItems: "center", marginTop: 20 }}>
      <div style={{ marginBottom: 12 }}>
        <input value={searchId} onChange={(e) => setSearchId(e.target.value)} placeholder="Buscar por ID" />
        <button onClick={handleSearch} style={{ marginLeft: 6 }}>
          Buscar
        </button>
      </div>

      {page && page.content.length > 0 ? (
        <>
          <BusTable buses={page.content} />
          <Pagination currentPage={page.number} totalPages={page.totalPages} onPageChange={setCurrentPage} />
        </>
      ) : (
        <p>No se encontraron buses.</p>
      )}
    </div>
  );
};

export default BusView;
