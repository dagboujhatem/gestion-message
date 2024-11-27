export interface Partenaire {
  id: number;
  alias: string;
  type: string;
  direction: EDirection;
  application: string;
  processedFlowType: EProcessedFlowType;
  description: string;
}
export enum EDirection {
  INBOUND = 'INBOUND',
  OUTBOUND = 'OUTBOUND'
}

export enum EProcessedFlowType {
  MESSAGE = 'MESSAGE',
  ALERTING = 'ALERTING',
  NOTIFICATION = 'NOTIFICATION'
}


