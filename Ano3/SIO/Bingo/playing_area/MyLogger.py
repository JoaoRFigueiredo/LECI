import hashlib
import logging
class MyLogger:
    def __init__(self, name, log_file, log_format, log_level=logging.INFO):
        self.logger = logging.getLogger(name)
        self.logger.setLevel(log_level)

        file_handler = logging.FileHandler(log_file, mode='w')
        formatter = logging.Formatter(log_format)
        file_handler.setFormatter(formatter)
        self.logger.addHandler(file_handler)

        #stream_handler = logging.StreamHandler()
        #stream_handler.setFormatter(formatter)
        #self.logger.addHandler(stream_handler)

        self.sequence_number = 1
        self.prev_record = None
        self.log_file = log_file

    def info(self, message, data=None):
        if self.sequence_number == 1:
            with open(self.log_file, 'w') as f:
                f.write('')

        if data.get('signature') != None:
            signature = "Signature:" +str(data.get('signature')) 
        else:
            signature = 'No signature'
        prev_record = hashlib.sha256(str(self.prev_record).encode('utf-8')).hexdigest() if self.prev_record is not None else None
        extra = { 'sequence_number': self.sequence_number, 'prev_record': prev_record, 'signature': signature }

        logger = logging.LoggerAdapter(self.logger, extra)
        logger.info(message)
        self.prev_record = message
        self.sequence_number += 1

logger = MyLogger('__name__', 'server.log', '%(sequence_number)03d,%(asctime)s,%(prev_record)s,%(message)s,%(signature)s', logging.INFO)



