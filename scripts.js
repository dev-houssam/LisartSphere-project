// Example list of books
const books = [
    { title: "Le Petit Prince", author: "Antoine de Saint-Exupéry", genre: "fiction", status: "to-read", img: "https://via.placeholder.com/200x300?text=Le+Petit+Prince" },
    { title: "1984", author: "George Orwell", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=1984" },
    { title: "Regale Toi", author: "Yuval Noah Harari", genre: "non-fiction", status: "reading", img: "https://via.placeholder.com/200x300?text=Regale+Toi" },
    { title: "La Vérité sur l'affaire Harry Quebert", author: "Joël Dicker", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=Harry+Quebert" },
    { title: "Le Petit Prince", author: "Antoine de Saint-Exupéry", genre: "fiction", status: "to-read", img: "https://via.placeholder.com/200x300?text=Le+Petit+Prince" },
    { title: "1984", author: "George Orwell", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=1984" },
    { title: "Regale Toi", author: "Yuval Noah Harari", genre: "non-fiction", status: "reading", img: "https://via.placeholder.com/200x300?text=Regale+Toi" },
    { title: "La Vérité sur l'affaire Harry Quebert", author: "Joël Dicker", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=Harry+Quebert" },
    { title: "Le Petit Prince", author: "Antoine de Saint-Exupéry", genre: "fiction", status: "to-read", img: "https://via.placeholder.com/200x300?text=Le+Petit+Prince" },
    { title: "1984", author: "George Orwell", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=1984" },
    { title: "Regale Toi", author: "Yuval Noah Harari", genre: "non-fiction", status: "reading", img: "https://via.placeholder.com/200x300?text=Regale+Toi" },
    { title: "La Vérité sur l'affaire Harry Quebert", author: "Joël Dicker", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=Harry+Quebert" },
    { title: "Le Petit Prince", author: "Antoine de Saint-Exupéry", genre: "fiction", status: "to-read", img: "https://via.placeholder.com/200x300?text=Le+Petit+Prince" },
    { title: "1984", author: "George Orwell", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=1984" },
    { title: "Regale Toi", author: "Yuval Noah Harari", genre: "non-fiction", status: "reading", img: "https://via.placeholder.com/200x300?text=Regale+Toi" },
    { title: "La Vérité sur l'affaire Harry Quebert", author: "Joël Dicker", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=Harry+Quebert" },
    { title: "Le Petit Prince", author: "Antoine de Saint-Exupéry", genre: "fiction", status: "to-read", img: "https://via.placeholder.com/200x300?text=Le+Petit+Prince" },
    { title: "1984", author: "George Orwell", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=1984" },
    { title: "Regale Toi", author: "Yuval Noah Harari", genre: "non-fiction", status: "reading", img: "https://via.placeholder.com/200x300?text=Regale+Toi" },

    { title: "La Vérité sur l'affaire Harry Quebert", author: "Joël Dicker", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=Harry+Quebert" },
    

 { title: "Les Mille et Une Nuits", author: "Anonyme", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=Mille+et+Une+Nuits" },

 { title: "Persepolis", author: "Marjane Satrapi", genre: "bande dessinée", status: "reading", img: "https://via.placeholder.com/200x300?text=Persepolis" },

 { title: "Le Prophète", author: "Khalil Gibran", genre: "poésie", status: "completed", img: "https://via.placeholder.com/200x300?text=Le+Prophete" },

 { title: "Nedjma", author: "Kateb Yacine", genre: "fiction", status: "to-read", img: "https://via.placeholder.com/200x300?text=Nedjma" },

 { title: "L'Alchimiste", author: "Paulo Coelho", genre: "fiction", status: "reading", img: "https://via.placeholder.com/200x300?text=L+Alchimiste" },

 { title: "La Nuit sacrée", author: "Tahar Ben Jelloun", genre: "fiction", status: "completed", img: "https://via.placeholder.com/200x300?text=La+Nuit+Sacree" }
  ];
  
  // Function to render books in the grid
  function renderBooks(filteredBooks) {
    const bookGrid = document.getElementById("book-grid");
    bookGrid.innerHTML = ""; // Clear existing books
  
    filteredBooks.forEach(book => {
      const bookCard = document.createElement("div");
      bookCard.classList.add("book-card");
  
      bookCard.innerHTML = `
        <img src="${book.img}" alt="${book.title}">
        <div class="book-info">
          <h3>${book.title}</h3>
          <p>${book.author}</p>
        </div>
      `;
  
      bookGrid.appendChild(bookCard);
    });
  }
  
  // Filter and search function
  function searchBooks() {
    const searchTerm = document.getElementById("search-bar").value.toLowerCase();
    const genreFilter = document.getElementById("genre-filter").value;
    const statusFilter = document.getElementById("status-filter").value;
  
    const filteredBooks = books.filter(book => {
      const matchesSearch = book.title.toLowerCase().includes(searchTerm) || book.author.toLowerCase().includes(searchTerm);
      const matchesGenre = genreFilter ? book.genre === genreFilter : true;
      const matchesStatus = statusFilter ? book.status === statusFilter : true;
  
      return matchesSearch && matchesGenre && matchesStatus;
    });
  
    renderBooks(filteredBooks);
  }
  
  // Initial render of books
  renderBooks(books);
  