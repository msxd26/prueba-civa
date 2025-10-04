import React from "react";

interface PaginationProps {
  currentPage: number;
  totalPages: number;
  onPageChange: (newPage: number) => void;
}

const Pagination: React.FC<PaginationProps> = ({ currentPage, totalPages, onPageChange }) => {
  const isFirstPage = currentPage === 0;
  const isLastPage = currentPage + 1 >= totalPages;

  return (
    <div style={{ marginTop: 16 }}>
      <button disabled={isFirstPage} onClick={() => onPageChange(currentPage - 1)}>
        Anterior
      </button>
      <span style={{ margin: "0 10px" }}>
        Página {currentPage + 1} de {totalPages}
      </span>
      <button disabled={isLastPage} onClick={() => onPageChange(currentPage + 1)}>
        Siguiente
      </button>
    </div>
  );
};

export default Pagination;
