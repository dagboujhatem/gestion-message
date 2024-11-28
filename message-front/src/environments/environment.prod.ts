declare var window: {
  env: {
    apiUrl: string;
  };
};

export const environment = {
  production: true,
  apiUrl: window["env"]?.apiUrl || "default",
};
