export interface BookDetails {
  isbn: string;
  title: string;
  subtitle: string;
  price: string;
  image: string;

  authors: string;
  publisher: string;
  pages: number;
  year: number;
  rating: number;
  desc: string;
  pdf: Map<string, string>;

}
