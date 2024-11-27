export interface Message {
  id: number;
  content: string;
  status: EStatutMessage;
  receivedAt: string;
}

export enum EStatutMessage {
  PENDING = 'PENDING',
  PROCESSED = 'PROCESSED',
  FAILED = 'FAILED'
}

