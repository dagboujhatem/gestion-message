// env.d.ts
declare global {
  interface Window {
    env: {
      apiUrl: string;
      // Add any other properties as needed
    };
  }
}

export {};
